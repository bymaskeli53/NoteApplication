package com.example.noteapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.noteapplication.databinding.FragmentListNotesBinding
import com.example.noteapplication.databinding.FragmentNoteBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class NoteListFragment : Fragment(R.layout.fragment_list_notes) {

    private val viewModel: NoteViewModel by viewModels()

    private val binding get() = _binding!!

    private var _binding: FragmentListNotesBinding? = null




    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListNotesBinding.inflate(inflater, container, false)
        val view = binding.root
        return view






    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewLifecycleOwner.lifecycleScope.launch {

            val noteList = viewModel.getAllNotesFromRoom()
            val adapter = NoteAdapter(noteList)
            binding.recyclerview.layoutManager = LinearLayoutManager(requireContext())

            // To divide between items
            binding.recyclerview.addItemDecoration(DividerItemDecoration(context,DividerItemDecoration.VERTICAL))
            binding.recyclerview.adapter = adapter



        }

        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}