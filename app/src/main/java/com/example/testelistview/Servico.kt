package com.example.testelistview

open class Servico(val id:Int, var nome:String, var valor: Double)

data class ItemPedido(val servico: Servico, val observacao:String, val quantidade:Int)

class Pedido (val listaItens: List<ItemPedido>, val numeroPedido: Int)