package projeto.mymarketapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import projeto.leopoldo.livros.ProdutoAdapter
import projeto.mymarketapp.model.Produto
import projeto.mymarketapp.viewmodels.ProdutoListViewModel
import androidx.lifecycle.Observer

class MainActivity : AppCompatActivity() {

    private val viewModel: ProdutoListViewModel by lazy {
        ViewModelProviders.of(this).get(ProdutoListViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        try {
            // getBooks para carregar dados do servidor
            viewModel.getProdutos().observe(this, Observer { produtos ->
                updateList(produtos)
            })
        } catch (e: Exception){
            Toast.makeText(this, R.string.message_error_load_products, Toast.LENGTH_SHORT).show()
        }
    }

    private fun updateList(produtos: List<Produto>) {
        rvBooks.layoutManager = LinearLayoutManager(this)
        rvBooks.adapter = ProdutoAdapter(produtos){}
    }

}
