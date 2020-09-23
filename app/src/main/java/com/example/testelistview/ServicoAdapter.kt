package com.example.testelistview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.item_servico.view.*


open class ServicoAdapter(val context: Context, val listaServico: List<Servico>):BaseAdapter() {
    override fun getCount(): Int {
        return listaServico.size
    }

    override fun getItem(position: Int): Any {
        return listaServico[position]
    }

    override fun getItemId(position: Int): Long {
        return listaServico[position].id.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        if(convertView != null){
            view = convertView
        }else{
            view = LayoutInflater.from(context).inflate(
                R.layout.item_servico,
                parent,
                false
            )
        }

        val textView_id = view.itemServico_id
        val textView_nome = view.itemServico_nome
        val textView_preco = view.itemServico_preco
        val btn_itemServico = view.itemServico_btn

        val servico = listaServico[position]
        textView_id.text = position.toString()
        textView_nome.text = servico.nome
        textView_preco.text = servico.valor.toString()
        btn_itemServico.setOnClickListener{ Toast.makeText(context, "${position + 1} - ${servico.nome}", Toast.LENGTH_SHORT).show() }

        return view
    }

}