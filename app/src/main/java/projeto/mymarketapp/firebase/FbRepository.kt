package projeto.mymarketapp.firebase

import androidx.lifecycle.LiveData
import com.google.firebase.firestore.FirebaseFirestore
import projeto.mymarketapp.model.Produto

class FbRepository {

    // prover acesso ao banco de dados
    private val firestore = FirebaseFirestore.getInstance()

    fun loadProdutos(): LiveData<List<Produto>>{
        return object : LiveData<List<Produto>>(){
            override fun onActive() {
                super.onActive()

                firestore.collection(PRODUTOS_KEY)
                    .addSnapshotListener { querySnapshot, firebaseFirestoreException ->
                        if (firebaseFirestoreException == null){
                            val produtos = querySnapshot?.map { document ->
                                val produto = document.toObject(Produto::class.java)
                                produto.id = document.id
                                produto
                            }
                            value = produtos
                        }
                    }
            }
        }
    }

    companion object {
        const val PRODUTOS_KEY = "produtos"
    }
}