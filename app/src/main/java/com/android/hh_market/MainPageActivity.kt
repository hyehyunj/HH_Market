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
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.hh_market.databinding.ActivityMainPageBinding

class MainPageActivity : AppCompatActivity() {
    private lateinit var _binding: ActivityMainPageBinding
    private lateinit var adapter: Adapter
    private val productList = Product.getProductData()

    companion object {
        private const val TAG = "MainPageActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainPageBinding.inflate(layoutInflater)
        setContentView(_binding.root)


        //클릭 이벤트 : 클릭 시 디테일페이지 호출, 롱클릭 시 삭제
        val intent = Intent(this, DetailPageActivity::class.java)
        adapter = Adapter(productList, itemClickListener = { item, position ->
            intent.putExtra("DATA", productList[position])
            startActivity(intent)
        }, itemLongClickListener = { item, position ->
            adapter.notifyItemRemoved(position)
            productList.removeAt(position)
            adapter.notifyItemRangeChanged(position, adapter.itemCount)
            return@Adapter true
        })

        //어댑터 호출
        getAdapter()

        //뒤로가기버튼 호출
        btnBackListener()

        //알림버튼 호출
        _binding.toolbar.btnToolbarNotification.setOnClickListener {
            btnNotificationListener()
        }
    }


    //어댑터 함수
    private fun getAdapter() {
        _binding.mainRecyclerView.adapter = adapter
        _binding.mainRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL))
        }
    }


    //알림버튼 함수
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

    //뒤로가기버튼 함수 : 다이얼로그
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





