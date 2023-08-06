package com.example.project2

import android.graphics.BitmapFactory
import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BottomFrag.newInstance] factory method to
 * create an instance of this fragment.
 */
class BottomFrag : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var weather_Image_View: ImageView
    private lateinit var wheel_Image_View: ImageView
    private var current_Time_In_Millis: Long = 0
    private lateinit var date_textView: TextView

    private lateinit var viewModel: ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_bottom, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(ViewModel::class.java)
        weather_Image_View = view.findViewById(R.id.season_imageView)
        wheel_Image_View = view.findViewById(R.id.wheel_imageView)

        val animation = AnimationUtils.loadAnimation(context, R.anim.rotate)
        animation.duration = 1000

        wheel_Image_View.startAnimation(animation)

        date_textView = view.findViewById(R.id.date_tView)

        val timeFormat = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
        val currentDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-yy"))

        date_textView.text = currentDate + " " + timeFormat.format(Date(System.currentTimeMillis()))

        return view
    }





    fun is15Seconds() {
        val btnPressedTimeInMillis = viewModel.pressedTimeInMillis
        val fadeInAnimation = AnimationUtils.loadAnimation(context, R.anim.fade_in)

        val isPlayedFromStart = viewModel.musicPlayedFromBeggining.value
        if (isPlayedFromStart!!) {
            view?.setBackgroundColor(
                ContextCompat.getColor(
                    this.requireContext(),
                    R.color.orange_red
                )
            )
            view?.startAnimation(fadeInAnimation)
            val bitmap = BitmapFactory.decodeResource(resources, R.drawable.spring)
            weather_Image_View.setImageBitmap(bitmap)
            var mediaPlayer: MediaPlayer = MediaPlayer.create(
                context,
                R.raw.spring_song
            )
            viewModel.setMusicPlayer(mediaPlayer)

            mediaPlayer.start()
            weather_Image_View.tag = "1"
            viewModel.setIsMusicPlayedFromBeggining(false)
        }

        if (current_Time_In_Millis - btnPressedTimeInMillis.value!! > 15000 && !isPlayedFromStart) {
            var mediaPlayer = viewModel.music.value
            if (mediaPlayer!!.isPlaying) {
                mediaPlayer.stop()
            }
            when (weather_Image_View.tag) {
                "1" -> {
                    view?.setBackgroundColor(
                        ContextCompat.getColor(
                            this.requireContext(),
                            R.color.sea_green
                        )
                    )
                    view?.startAnimation(fadeInAnimation)
                    val bitmap = BitmapFactory.decodeResource(resources, R.drawable.summer)
                    weather_Image_View.setImageBitmap(bitmap)

                    mediaPlayer = MediaPlayer.create(context, R.raw.summer_song)
                    mediaPlayer?.start()
                    viewModel.setMusicPlayer(mediaPlayer)

                    weather_Image_View.tag = "2"
                }
                "2" -> {
                    view?.setBackgroundColor(
                        ContextCompat.getColor(
                            this.requireContext(),
                            R.color.yellow
                        )
                    )
                    view?.startAnimation(fadeInAnimation)
                    val bitmap = BitmapFactory.decodeResource(resources, R.drawable.autumn)
                    weather_Image_View.setImageBitmap(bitmap)

                    mediaPlayer = MediaPlayer.create(context, R.raw.autumn_song)
                    mediaPlayer?.start()
                    viewModel.setMusicPlayer(mediaPlayer)

                    weather_Image_View.tag = "3"
                }
                "3" -> {
                    view?.setBackgroundColor(
                        ContextCompat.getColor(
                            this.requireContext(),
                            R.color.white
                        )
                    )
                    view?.startAnimation(fadeInAnimation)
                    val bitmap = BitmapFactory.decodeResource(resources, R.drawable.winter)
                    weather_Image_View.setImageBitmap(bitmap)
                    mediaPlayer = MediaPlayer.create(context, R.raw.winter_song)
                    mediaPlayer?.start()
                    viewModel.setMusicPlayer(mediaPlayer)

                    weather_Image_View.tag = "4"
                }
                else -> {
                    view?.setBackgroundColor(
                        ContextCompat.getColor(
                            this.requireContext(),
                            R.color.orange_red
                        )
                    )
                    view?.startAnimation(fadeInAnimation)
                    val bitmap = BitmapFactory.decodeResource(resources, R.drawable.spring)
                    weather_Image_View.setImageBitmap(bitmap)
                    mediaPlayer = MediaPlayer.create(context, R.raw.spring_song)
                    mediaPlayer?.start()
                    viewModel.setMusicPlayer(mediaPlayer)

                    weather_Image_View.tag = "1"
                }
            }
            viewModel.setPressedTimeInMillis(btnPressedTimeInMillis.value!! + 15000)
        }

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BottomFrag.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BottomFrag().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
