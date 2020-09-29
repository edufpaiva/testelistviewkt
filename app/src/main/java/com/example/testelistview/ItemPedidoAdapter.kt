package com.example.testelistview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_item_pedido.view.*

class ItemPedidoAdapter(private val context: Context, private val listaItens: List<ItemPedido>) : RecyclerView.Adapter<ItemPedidoAdapter.ViewHolder>() {

    //  Aqui ele identifica o modelo que vc criou pra preencher o recycler view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_item_pedido, parent, false)
        return ViewHolder(view)
    }

    //  Aqui ele liga os elementos identificados aos itens em si e repete para cada elemento da lista (position)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // refere item a item
        val itemPedido = listaItens[position]
        holder.nomeServico?.text = itemPedido.servico.nome
        holder.quantidade?.text = itemPedido.servico.valor.toString()
    }

    //  Apenas retorna
    override fun getItemCount(): Int = listaItens.size

    //  Aqui ele identifica os elementos da view ~layout~
    class ViewHolder(item: View): RecyclerView.ViewHolder(item){
        val nomeServico = item.itemPedido_txtNomeServico
        val quantidade = item.itemPedido_txtQuantidade

    }

}
