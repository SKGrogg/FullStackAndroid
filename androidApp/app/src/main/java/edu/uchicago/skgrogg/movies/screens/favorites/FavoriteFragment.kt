package edu.uchicago.skgrogg.movies.screens.favorites

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.activity.viewModels
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.viewmodel.compose.viewModel
import edu.uchicago.skgrogg.movies.R
import edu.uchicago.skgrogg.movies.models.Favorite
import edu.uchicago.skgrogg.movies.screens.favorites.placeholder.PlaceholderContent
import edu.uchicago.skgrogg.movies.viewmodels.FavoriteViewModel

/**
 * A fragment representing a list of Items.
 */
class FavoriteFragment : Fragment() {

    private var columnCount = 1

    var mAdapter: FavoriteRecyclerViewAdapter? = null
    var mList = ArrayList<Favorite>()

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i("Crashing Check", "Fragment was Created!")
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val model: FavoriteViewModel by viewModels()
        model.mFavorites.observe(viewLifecycleOwner, { favorites ->
            mList.clear()
            mList.addAll(favorites!!)
            mAdapter?.notifyItemRangeChanged(0, mList.size-1)

        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_item_list, container, false)

        // Set the adapter
        if (view is RecyclerView) {
            mAdapter = FavoriteRecyclerViewAdapter(mList)
            with(view) {
                layoutManager = LinearLayoutManager(context)
                adapter = mAdapter
            }
        }
        return view
    }

    companion object {

        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(columnCount: Int) =
            FavoriteFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }
}