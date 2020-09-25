package com.example.testelistview

data class ItemPedido(val servico: Servico, val observacao:String, val quantidade:Int)

class Pedido (val listaItens: List<ItemPedido>, val numeroPedido: Int){
}