package com.example.myapplication.activities.userslist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.RestApi.Service
import com.example.myapplication.activities.RacerViewModel
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

        val listUsers = service.getUsers()


        binding.usersRecyclerView.layoutManager = LinearLayoutManager(activity)
        val data = ArrayList<UsersViewModel>()

        for (user in listUsers) {
            data.add(UsersViewModel(user))
        }

        val adapter = UsersAdapter(data) { _usersViewModel ->
            run {
//                sharedViewModel.setFirstName(racersViewModel.racer.firstName)
//                sharedViewModel.setLastName(racersViewModel.racer.lastName)
//                sharedViewModel.setDateOfBirth(racersViewModel.racer.dateOfBirth)
//                sharedViewModel.setVehicleBrandName(racersViewModel.racer.vehicleBrand)
//                sharedViewModel.setVehicleModel(racersViewModel.racer.vehicleModel)
//                sharedViewModel.setTrackName(racersViewModel.racer.trackName)
//                sharedViewModel.setRecordTime(racersViewModel.racer.recordTimeOfTrack)

                findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
            }
        }


        binding.usersRecyclerView.adapter = adapter

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}