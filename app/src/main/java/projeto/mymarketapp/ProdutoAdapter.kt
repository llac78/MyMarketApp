package projeto.leopoldo.livros

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import projeto.mymarketapp.R
import projeto.mymarketapp.databinding.ItemProdutoBinding
import projeto.mymarketapp.model.Produto

class ProdutoAdapter(val produtos: List<Produto>,
                  private val onClick: (Produto) -> Unit)
    : RecyclerView.Adapter<ProdutoAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_produto, parent, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding?.run {
            val currentProduto = produtos[position]
            produto = currentProduto
            executePendingBindings()
        }
    }

    override fun getItemCount(): Int = produtos.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = DataBindingUtil.bind<ItemProdutoBinding>(view)
    }
}