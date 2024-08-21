package com.example.ipr.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.example.ipr.data.SimpsonsItem
import com.example.ipr.databinding.FragmentEditUserBinding
import com.example.ipr.domain.OnUserEditListener
import com.example.ipr.presentation.MainActivity.Companion.EDIT_FRAGMENT

class EditUserFragment : Fragment() {

    private var onUserEditListener: OnUserEditListener? = null
    private var binding: FragmentEditUserBinding? = null
    private var user: SimpsonsItem? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): LinearLayout? {

        binding = FragmentEditUserBinding.inflate(inflater)

        val editTextName = binding?.editTextName
        val editSurname = binding?.editSurname
        val editTextNumber = binding?.editTextNumber
        val buttonEditUser = binding?.buttonEditUser

        buttonEditUser?.setOnClickListener {
            val name = editTextName?.text.toString()
            val surname = editSurname?.text.toString()
            val phoneNumber = editTextNumber?.text.toString()

            user?.let { userItem ->
                val updatedUser = SimpsonsItem(
                    userItem.id,
                    userItem.photo,
                    name,
                    surname,
                    phoneNumber
                )
                onUserEditListener?.onUserEdited(updatedUser)
            }
            requireActivity().supportFragmentManager.popBackStack(EDIT_FRAGMENT, 0)
        }
        return binding?.root
    }

    fun setOnUserEditListener(listener: OnUserEditListener) {
        onUserEditListener = listener
    }

    fun setUser(user: SimpsonsItem) {
        this.user = user
        binding?.let { binding ->
            binding.editTextName.setText(user.name)
            binding.editSurname.setText(user.surname)
            binding.editTextNumber.setText(user.phoneNumber)
        }
    }
}