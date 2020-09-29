package com.example.testelistview

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_fechar_pedido.*

class FecharPedido : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fechar_pedido)

        val pedidosPreference = getSharedPreferences("database", Context.MODE_PRIVATE)
        val pedidoJson = pedidosPreference.getString("pedido", "")
        if(pedidoJson != ""){
            val ggson = Gson()
            val pedido = ggson.fromJson(pedidoJson, Pedido::class.java)

            fecharPedido_rv.layoutManager = LinearLayoutManager(this)
            fecharPedido_rv.adapter = ItemPedidoAdapter(this, pedido.listaItens)
            fecharPedido_rv.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))

            fecharPedido_txtTitulo.text = "Pedidos #${pedido.numeroPedido}"
        }


    }


    override fun onStop() {
        super.onStop()
        val databasePreferences = getSharedPreferences("database", Context.MODE_PRIVATE)
        val pedidoAntigoJson = databasePreferences.getString("pedido", "")
        if (pedidoAntigoJson == ""){
            val servicoEngomar = Servico(15, "engomar", 10.0)
            val servicoPassar = Servico(15, "passar", 10.0)
            val servicoLavar = Servico(15, "lavar", 10.0)

            val listaItens = listOf<ItemPedido>(
                ItemPedido(servicoEngomar, "a tapioca", 3),
                ItemPedido(servicoPassar, "de leve", 2),
                ItemPedido(servicoLavar, "a jato", 10)
            )

            val pedido = Pedido(listaItens, 53)

            val ggson = Gson()
            val pedidoJson = ggson.toJson(pedido)
            val prefEditor = databasePreferences.edit()
            prefEditor.putString("pedido", pedidoJson).apply()

        }



    }
}