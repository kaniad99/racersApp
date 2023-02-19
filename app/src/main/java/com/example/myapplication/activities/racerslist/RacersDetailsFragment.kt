package com.example.myapplication.activities.racerslist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.activities.RacerViewModel
import com.example.myapplication.databinding.FragmentRacerDetailsBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class RacersDetailsFragment : Fragment() {

    private var _binding: FragmentRacerDetailsBinding? = null

    private val sharedViewModel : RacerViewModel by activityViewModels()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentRacerDetailsBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.textFirstName.text = sharedViewModel.firstName.value
        binding.textLastName.text = sharedViewModel.lastName.value
        binding.textDateOfBirth.text = sharedViewModel.dateOfBirth.value
        binding.textVehicleBrand.text = sharedViewModel.vehicleBrand.value
        binding.textVehicleModel.text = sharedViewModel.vehicleModel.value
        binding.textTrackName.text = sharedViewModel.trackName.value
        binding.textRecordTime.text = sharedViewModel.recordTime.value

        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}