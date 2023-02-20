package com.example.myapplication.activities.userslist

import android.app.AlertDialog
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
import com.example.myapplication.databinding.FragmentUserDetailsBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class UserDetailsFragment : Fragment() {

    private var _binding: FragmentUserDetailsBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val sharedViewModel : UserViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentUserDetailsBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.editButton.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }

        binding.deleteButton.setOnClickListener {
            val service = Service()

            val builder = AlertDialog.Builder(activity)
            builder.setTitle("Delete User")
            builder.setMessage("Are you sure you want to delete this user?")

            builder.setPositiveButton(android.R.string.yes) { dialog, which ->
                sharedViewModel.id.value?.let { it1 ->
                    if(service.deleteUser(it1))
                        Toast.makeText(activity, "Deleted user", Toast.LENGTH_SHORT).show()
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
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}