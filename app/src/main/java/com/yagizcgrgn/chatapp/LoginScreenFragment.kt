package com.yagizcgrgn.chatapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase
import com.yagizcgrgn.chatapp.databinding.FragmentLoginScreenBinding

class LoginScreenFragment : Fragment() {
    private lateinit var firebaseAuth: FirebaseAuth
    private var _binding : FragmentLoginScreenBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginScreenBinding.inflate(inflater,container,false)
        firebaseAuth = FirebaseAuth.getInstance()
        binding.btLogin.setOnClickListener {
            login(it)}
        return binding.root
    }

    override fun onStart() {
        super.onStart()

        val currentUser = firebaseAuth.currentUser
        if(currentUser != null){
        }
    }




    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun login(view: View){

        val email = binding.edtMail.text.toString()
        val password = binding.edtPassword.text.toString()

        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener() {
                if(it.isSuccessful){
                    //Send chat main fragment
                } else {
                    Toast.makeText(activity,"Try Again", Toast.LENGTH_LONG).show()
                    binding.edtPassword.setText("")
                }
            }

    }


}