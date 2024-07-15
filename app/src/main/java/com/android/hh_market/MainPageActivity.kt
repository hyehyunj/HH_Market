package com.android.hh_market

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.DialogInterface
import android.content.Intent
import android.icu.text.DecimalFormat
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.hh_market.databinding.ActivityMainPageBinding

class MainPageActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityMainPageBinding
    private val productList = Product.getProductData()
    private val adapter = Adapter(productList)

    companion object {
        private const val TAG = "MainPageActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainPageBinding.inflate(layoutInflater)
        setContentView(_binding.root)

        //어댑터 호출
        getAdapter()

        //뒤로가기버튼 호출
        btnBackListener()

        //알림버튼 호출
        _binding.toolbar.btnToolbarNotification.setOnClickListener {
            btnNotificationListener()
        }

        //디테일페이지 호출
        val intent = Intent(this, DetailPageActivity::class.java)
        adapter.itemClick = object : Adapter.ItemClick {
            override fun onClick(view: View, position: Int) {
                intent.putExtra("POSITION", position)
                intent.putExtra("DATA", productList[position])
                startActivity(intent)

            }
        }

        //like추가 호출
        getLike()

//        val like = intent.getIntExtra("like", 0)
//        productList[0].like++
//        getResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
//                result: ActivityResult ->
//            if (result.resultCode == RESULT_OK) {
//                val cbLike = result.data?.getIntExtra("like",0) ?: 0
//                productList[7].like + cbLike
//             }
//        }


//                getResult.launch(intent)

    }
    fun getLike() {
        val likeResult = intent.getBooleanExtra("LIKE", false)
        val positionResult = intent.getIntExtra("POSITION", 0)
        if(likeResult) productList[positionResult].like += 1
    }
    //어댑터 함수
    private fun getAdapter() {
        _binding.mainRecyclerView.adapter = adapter
        _binding.mainRecyclerView.layoutManager = LinearLayoutManager(this)
        val decoration = DividerItemDecoration(this,LinearLayoutManager.VERTICAL)
        _binding.mainRecyclerView.addItemDecoration(decoration)
    }


    //알림버튼 함수 - 작동안됨
    private fun btnNotificationListener() {
        val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        val builder: NotificationCompat.Builder
        //버전체크
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channelId = "one-channel"
            val channelName = "My Channel One"
            val channel = NotificationChannel(
                channelId,
                channelName,
                NotificationManager.IMPORTANCE_DEFAULT
            )
            //채널 등록
            manager.createNotificationChannel(channel)
            //채널을 이용하여 빌더 생성
            builder = NotificationCompat.Builder(this, channelId)
        } else {
            //버전 이하
            builder = NotificationCompat.Builder(this)
        }
        builder.run {
            setSmallIcon(R.drawable.ic_logo_eco)
            setWhen(System.currentTimeMillis())
            setContentTitle(getString(R.string.notifitacion_title))
            setContentText(getString(R.string.notifitacion_introduce))
        }
        manager.notify(1, builder.build())
    }


    //뒤로가기 버튼 함수, 다이얼로그
    private fun btnBackListener() {
        val btnBackListener = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                val builder = AlertDialog.Builder(this@MainPageActivity)
                builder.setTitle(getString(R.string.eco_market))
                builder.setMessage(getString(R.string.ask_finish))
                builder.setIcon(R.drawable.ic_logo_eco)

                val btnListener = DialogInterface.OnClickListener { dialog, which ->
                    when (which) {
                        DialogInterface.BUTTON_POSITIVE -> finish()
                    }
                }
                builder.setPositiveButton(getString(R.string.yes), btnListener)
                builder.setNegativeButton(getString(R.string.no), btnListener)
                builder.show()
            }
        }
        onBackPressedDispatcher.addCallback(this, btnBackListener)
    }


}





