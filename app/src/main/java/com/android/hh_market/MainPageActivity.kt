package com.android.hh_market

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.DialogInterface
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
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

        getAdapter()
        btnBackListener()

        _binding.toolbar.btnToolbarNotification.setOnClickListener {
            btnNotificationListener()
        }

        val intent = Intent(this, DetailPageActivity::class.java)
        val like = intent.getIntExtra("like", 0)
        productList[0].like++
//        getResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
//                result: ActivityResult ->
//            if (result.resultCode == RESULT_OK) {
//                val cbLike = result.data?.getIntExtra("like",0) ?: 0
//                productList[7].like + cbLike
//             }
//        }


        adapter.itemClick = object : Adapter.ItemClick {
            override fun onClick(view: View, position: Int) {
//               intent.putExtra("POSITION", position)
//                startActivity(intent)

//                getResult.launch(intent)

            }
        }


    }

    //adapter 연결
    private fun getAdapter() {
        _binding.mainRecyclerView.adapter = adapter
        _binding.mainRecyclerView.layoutManager = LinearLayoutManager(this)
    }


    //알림버튼
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
            setContentTitle("에코마켓 알림")
            setContentText("알립니다")
        }
        manager.notify(1, builder.build())
    }


    //뒤로가기 버튼, 다이얼로그
    private fun btnBackListener() {
        val btnBackListener = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                val builder = AlertDialog.Builder(this@MainPageActivity)
                builder.setTitle("에코마켓")
                builder.setMessage("종료 하시겠습니까?")
                builder.setIcon(R.drawable.ic_logo_eco)

                val btnListener = DialogInterface.OnClickListener { dialog, which ->
                    when (which) {
                        DialogInterface.BUTTON_POSITIVE -> finish()
                    }
                }
                builder.setPositiveButton("네", btnListener)
                builder.setNegativeButton("아니오", btnListener)
                builder.show()
            }
        }
        onBackPressedDispatcher.addCallback(this, btnBackListener)
    }


}





