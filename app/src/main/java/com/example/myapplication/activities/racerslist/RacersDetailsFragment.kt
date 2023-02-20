package com.example.myapplication.activities.racerslist

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.RestApi.Service
import com.example.myapplication.databinding.FragmentRacerDetailsBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class RacersDetailsFragment : Fragment() {

    private var _binding: FragmentRacerDetailsBinding? = null

    private val sharedViewModel: RacerViewModel by activityViewModels()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentRacerDetailsBinding.inflate(inflater, container, false)

        binding.deleteButton.setOnClickListener {
            val service = Service()

            val builder = AlertDialog.Builder(activity)
            builder.setTitle("Delete Racer")
            builder.setMessage("Are you sure you want to delete this racer?")

            builder.setPositiveButton(android.R.string.yes) { dialog, which ->
                sharedViewModel.id.value?.let { it1 ->
                    if(service.deleteRacer(it1))
                Toast.makeText(activity, "Deleted racer", Toast.LENGTH_SHORT).show()
                }
                findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
            }

            builder.setNegativeButton(android.R.string.no) { dialog, which ->
                Toast.makeText(
                    activity,
                    android.R.string.no, Toast.LENGTH_SHORT
                ).show()
            }

            builder.show()
        }


        binding.editButton.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_editRacerFragment)
        }

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

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}