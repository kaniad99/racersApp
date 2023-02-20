package com.example.myapplication.activities.userslist

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
import com.example.myapplication.RestApi.User
import com.example.myapplication.databinding.FragmentEditRacerBinding
import com.example.myapplication.databinding.FragmentEditUserBinding
import com.google.gson.JsonObject

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [EditUserFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class EditUserFragment : Fragment() {
    private var _binding: FragmentEditUserBinding? = null

    private val sharedViewModel: UserViewModel by activityViewModels()

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEditUserBinding.inflate(inflater, container, false)

        binding.textFirstName.setText(sharedViewModel.firstName.value)
        binding.textLastName.setText(sharedViewModel.lastName.value)
        binding.textDescription.setText(sharedViewModel.description.value)
        binding.textEmail.setText(sharedViewModel.email.value)

        binding.buttonSave.setOnClickListener {
            val service = Service()

            val user = User(
                binding.textFirstName.text.toString(),
                binding.textLastName.text.toString(),
                binding.textDescription.text.toString(),
                binding.textEmail.text.toString(),
                JsonObject()
            )

            if(sharedViewModel.id.value?.let { it1 -> service.editUser(it1, user) } == true){
                Toast.makeText(activity, "Saved changed user", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_editUserFragment_to_FirstFragment)
            }
        }

        // Inflate the layout for this fragment
        return binding.root
    }
}