package com.example.myapplication.activities

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.RestApi.Racer
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
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val racer1 = Racer("Dominik", "Kania", "01-01-2020", "Audi", "A6", "Tor Poznan", "1:05:22")
        val racer2 = Racer("Dominik2", "Kania", "01-01-2020", "Audi", "A6", "Tor Poznan", "1:05:22")
        val racer3 = Racer("Dominik3", "Kania", "01-01-2020", "Audi", "A6", "Tor Poznan", "1:05:22")

        val listRacers = ArrayList<Racer>()

        listRacers.add(racer1)
        listRacers.add(racer2)
        listRacers.add(racer3)


        val service = Service()

        val listRacers1 = service.getRacers()

        binding.textviewFirst.text = listRacers1[0].toString()

        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}