package com.example.ipr.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import com.example.ipr.data.VerticalItem
import com.example.ipr.databinding.FragmentEditUserBinding
import com.example.ipr.domain.OnUserEditListener

class EditUserFragment : Fragment() {

    private lateinit var binding: FragmentEditUserBinding
    private lateinit var user: VerticalItem
    private lateinit var onUserEditListener: OnUserEditListener

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEditUserBinding.inflate(inflater)

        val editTextName = binding.editTextName
        val editSurname = binding.editSurname
        val editTextNumber = binding.editTextNumber

        val buttonEditUser = binding.buttonEditUser
        buttonEditUser.setOnClickListener {
            val result = editTextName.text.toString()

            setFragmentResult("result_key", bundleOf("data" to result))
            val result2 = editSurname.text.toString()
            setFragmentResult("result_key2", bundleOf("data" to result2))
            val result3 = editTextNumber.text.toString()
            setFragmentResult("result_key3", bundleOf("data" to result3))

            val updatedUser = VerticalItem(
                user.id,
                user.photo,
                result,
                result2,
                result3
            )
            onUserEditListener.onUserEdited(updatedUser)
            requireActivity().supportFragmentManager.popBackStack("FragmentUser", 0)

        }
        return binding.root
    }

    fun setOnUserEditListener(listener: OnUserEditListener) {
        onUserEditListener = listener
    }

    fun setUser(user: VerticalItem) {
        this.user = user
        if (::binding.isInitialized) {
            binding.editTextName.setText(user.name)
            binding.editSurname.setText(user.surname)
            binding.editTextNumber.setText(user.phoneNumber)
        }
    }
}