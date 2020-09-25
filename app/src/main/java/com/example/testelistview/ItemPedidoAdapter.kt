package com.example.testelistview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_item_pedido.view.*

class ItemPedidoAdapter(private val context: Context, private val listaItens: List<ItemPedido>) : RecyclerView.Adapter<ItemPedidoAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_item_pedido, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemPedido = listaItens[position]
        holder.nomeServico?.text = itemPedido.servico.nome
        holder.quantidade?.text = itemPedido.servico.valor.toString()
    }

    override fun getItemCount(): Int = listaItens.size

    class ViewHolder(item: View): RecyclerView.ViewHolder(item){
        val nomeServico = item.itemPedido_txtNomeServico
        val quantidade = item.itemPedido_txtQuantidade

    }

}
