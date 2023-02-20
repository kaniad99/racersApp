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
import com.example.myapplication.databinding.FragmentFirstBinding
import com.google.gson.JsonObject

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    private val sharedViewModel: UserViewModel by activityViewModels()

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
                sharedViewModel.setFirstName(_usersViewModel.user.firstName)
                sharedViewModel.setLastName(_usersViewModel.user.lastName)
                sharedViewModel.setDescritpion(_usersViewModel.user.description)
                sharedViewModel.setEmail(_usersViewModel.user.email)
                sharedViewModel.setId(getId(_usersViewModel.user.links))

                findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
            }
        }
        binding.usersRecyclerView.adapter = adapter

        return binding.root
    }

    private fun getId(href: JsonObject): Int {
        val link = href.getAsJsonObject("user").get("href").asString
        return link.substringAfterLast("/").toInt();
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