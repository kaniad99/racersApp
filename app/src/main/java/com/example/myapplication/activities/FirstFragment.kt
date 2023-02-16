package com.example.myapplication.activities

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.RestApi.Service
import com.example.myapplication.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        val service = Service()

        val listRacers = service.getRacers()

        ////////////////////////////////////////////////////////
//         RECYCLER VIEW SETUP
        binding.racersRecyclerView.layoutManager = LinearLayoutManager(activity)
        val data = ArrayList<RacersViewModel>()

        for (racer in listRacers) {
            data.add(RacersViewModel(racer))
        }

        val adapter = RacersAdapter(data)

        binding.racersRecyclerView.adapter = adapter
        ////////////////////////////////////////////

//        binding.buttonFirst.setOnClickListener {
//            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
//        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}