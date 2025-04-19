package com.example.core.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.viewbinding.ViewBinding
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

abstract class BaseFragment<VB : ViewBinding, VM : BaseViewModel> : Fragment() {

    protected lateinit var viewModel: VM
    protected lateinit var binding: VB

    abstract fun initViewModel(): Class<VM>
    abstract fun initBinding(inflater: LayoutInflater, container: ViewGroup?): VB
    abstract fun observeViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = initBinding(inflater, container)
        viewModel = ViewModelProvider(this)[initViewModel()]

        observeViewModel()
        observeUiState()

        return binding.root
    }

    private fun observeUiState(){
        viewModel.loading.observe(viewLifecycleOwner) { isLoading ->
            //handleLoading(isLoading)
        }

        viewModel.error.observe(viewLifecycleOwner) { errorMessage ->
            showError(errorMessage)
        }
    }

    private fun showError(errorMessage: String) {
        errorMessage.let {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        }
    }

    protected fun <T> collectFlow(
        flow: Flow<T>,
        onSuccess: (T) -> Unit
    ) {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                flow.collectLatest { onSuccess(it) }
            }
        }
    }
}
