package com.velasteguidaniel.basicactivity

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.velasteguidaniel.basicactivity.databinding.FragmentFirstBinding

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
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            val dialogBuilder = AlertDialog.Builder(context)
            dialogBuilder.setTitle("Confirmación")
            dialogBuilder.setMessage("¿Esta seguro que desea ir al siguiente Fragmento?")
            dialogBuilder.setPositiveButton("Sí", DialogInterface.OnClickListener { _, _ ->
                findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
            })
            dialogBuilder.setNegativeButton("No", DialogInterface.OnClickListener { dialog, which ->
                //pass
            })
            dialogBuilder.create().show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}