package com.example.myapplication.activities.racerslist

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.RestApi.Service
import com.example.myapplication.activities.CreateRacerActivity
import com.example.myapplication.activities.RacerViewModel
import com.example.myapplication.activities.RacersViewModel
import com.example.myapplication.databinding.FragmentRacersListBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class RacersListFragment : Fragment() {

    private var _binding: FragmentRacersListBinding? = null

    private val sharedViewModel: RacerViewModel by activityViewModels()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRacersListBinding.inflate(inflater, container, false)
        val service = Service()

        val listRacers = service.getRacers()

        ////////////////////////////////////////////////////////
//         RECYCLER VIEW SETUP
        binding.racersRecyclerView.layoutManager = LinearLayoutManager(activity)
        val data = ArrayList<RacersViewModel>()

        for (racer in listRacers) {
            data.add(RacersViewModel(racer))
        }

        val adapter = RacersAdapter(data) { racersViewModel ->
            run {
                sharedViewModel.setFirstName(racersViewModel.racer.firstName)
                sharedViewModel.setLastName(racersViewModel.racer.lastName)
                sharedViewModel.setDateOfBirth(racersViewModel.racer.dateOfBirth)
                sharedViewModel.setVehicleBrandName(racersViewModel.racer.vehicleBrand)
                sharedViewModel.setVehicleModel(racersViewModel.racer.vehicleModel)
                sharedViewModel.setTrackName(racersViewModel.racer.trackName)
                sharedViewModel.setRecordTime(racersViewModel.racer.recordTimeOfTrack)

                findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
            }
        }


        binding.racersRecyclerView.adapter = adapter

        binding.fab.setOnClickListener {
            Toast.makeText(activity, "Add Test", Toast.LENGTH_SHORT).show()
            val intent = Intent(activity, CreateRacerActivity::class.java)
            startActivity(intent)
        }

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