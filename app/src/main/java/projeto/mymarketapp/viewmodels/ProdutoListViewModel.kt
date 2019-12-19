package projeto.mymarketapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import projeto.mymarketapp.firebase.FbRepository
import projeto.mymarketapp.model.Produto

class ProdutoListViewModel : ViewModel() {

    private val repo = FbRepository()
    private var produtoList: LiveData<List<Produto>>? = null

    fun getProdutos(): LiveData<List<Produto>>{
        var list = produtoList
        if (list == null){
            list = repo.loadProdutos()
            produtoList = list
        }
        return list
    }
}