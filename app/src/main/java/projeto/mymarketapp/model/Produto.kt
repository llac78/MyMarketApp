package projeto.mymarketapp.model

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR
import org.parceler.Parcel

@Parcel
class Produto : BaseObservable() {
    @Bindable
    var id: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.id)
        }
    @Bindable
    var nome: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.nome)
        }
    @Bindable
    var descricao: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.descricao)
        }

}

