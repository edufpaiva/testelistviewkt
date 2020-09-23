package com.example.testelistview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_lista_servicos.*

class ListaServicos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_servicos)

        val listaServico = listOf<Servico>(
            Servico(id=0, nome = "pop", valor = 1.5),
            Servico(id=0, nome = "Cicle", valor = 1.6),
            Servico(id=0, nome = "popcorn", valor = 1.78),
            Servico(id=0, nome = "popopo", valor = 1.23),
            Servico(id=0, nome = "popstar", valor = 99.99),
            Servico(id=0, nome = "popfunko", valor = 89.90),
        )

        val listaServicoString = listaServico.map {  it -> it.nome }

        val adapter = ArrayAdapter<String> (
            this,
            android.R.layout.simple_list_item_1,
            listaServicoString
        )

        preencheServicoAdapter(listaServico)


    }

    private fun preencheServicoAdapter(listaServico: List<Servico>){
        lvListaServicos.adapter = ServicoAdapter(this, listaServico)
//        lvListaServicos.setOnItemClickListener{ parent,
//                                                view,
//                                                posicao,
//                                                _ -> Toast.makeText(applicationContext, "Servico $posicao - ${listaServico[posicao].id}",
//            Toast.LENGTH_LONG)
//        }
    }

    private fun preencheComArrayAdapter(listaServicoString: List<String>){
        val adapter = ArrayAdapter<String> (
            this,
            android.R.layout.simple_list_item_1,
            listaServicoString
        )

        lvListaServicos.adapter = adapter

        lvListaServicos.setOnItemClickListener{ parent,
                                                view,
                                                posicao,
                                                _ -> Toast.makeText(applicationContext, "Servico $posicao - ${listaServicoString[posicao]}",
                                                Toast.LENGTH_LONG)
        }





    }



}