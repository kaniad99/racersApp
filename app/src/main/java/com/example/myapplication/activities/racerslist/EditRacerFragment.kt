package com.example.myapplication.activities.racerslist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.RestApi.Racer
import com.example.myapplication.RestApi.Service
import com.example.myapplication.databinding.FragmentEditRacerBinding
import com.google.gson.JsonObject

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [EditRacerFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class EditRacerFragment : Fragment() {

    private val sharedViewModel: RacerViewModel by activityViewModels()
    private var _binding: FragmentEditRacerBinding? = null

    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEditRacerBinding.inflate(inflater, container, false)

        binding.textFirstName.setText(sharedViewModel.firstName.value)
        binding.textLastName.setText(sharedViewModel.lastName.value)
        binding.textDateOfBirth.setText(sharedViewModel.dateOfBirth.value)
        binding.textVehicleBrand.setText(sharedViewModel.vehicleBrand.value)
        binding.textVehicleModel.setText(sharedViewModel.vehicleModel.value)
        binding.textTrackName.setText(sharedViewModel.trackName.value)
        binding.textRecordTime.setText(sharedViewModel.recordTime.value)


        binding.saveButton.setOnClickListener {
            val service = Service()

            val racer = Racer(
                binding.textFirstName.text.toString(),
                binding.textLastName.text.toString(),
                binding.textDateOfBirth.text.toString(),
                binding.textVehicleBrand.text.toString(),
                binding.textVehicleModel.text.toString(),
                binding.textTrackName.text.toString(),
                binding.textRecordTime.text.toString(),
                JsonObject()
            )

            if(sharedViewModel.id.value?.let { it1 -> service.editRacer(it1, racer) } == true){
                Toast.makeText(activity, "Saved changes racer", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_editRacerFragment_to_FirstFragment)
            }
        }
        // Inflate the layout for this fragment
        return binding.root
    }
}