import 'package:flutter/material.dart';

import 'package:http/http.dart' as http;
import 'dart:async';
import 'dart:convert';

const urlApi = "https://api.hgbrasil.com/finance?format=json-cors&key=145ac9b8";

void main(){
  runApp(MaterialApp(
    home: Home()
  ));
}

class Home extends StatefulWidget {
  @override
  _HomeState createState() => _HomeState();
}

class _HomeState extends State<Home> {
  final realController = TextEditingController();
  final dolarController = TextEditingController();
  final euroController = TextEditingController();

  double dolar;
  double euro;

  void _Real(String texto){
    double real = double.parse(texto);

    dolarController.text = (real / dolar).toStringAsFixed(2);
    euroController.text = (real / euro).toStringAsFixed(2);
  }

  void _Dolar(String texto){
    double dolar = double.parse(texto);

    realController.text = (dolar * this.dolar).toStringAsFixed(2);
    euroController.text = (dolar * this.dolar / euro).toStringAsFixed(2);
  }

  void _Euro(String texto){
    double euro = double.parse(texto);

    realController.text = (euro * this.euro).toStringAsFixed(2);
    dolarController.text = (euro * this.dolar / dolar).toStringAsFixed(2);
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Conversor de Moedas"),
        backgroundColor: Colors.amber,
      ),
          body:FutureBuilder<Map>(
            future: buscarDadosDaApi(),
            builder: (context, snapshot) {
              switch(snapshot.connectionState){
                case ConnectionState.none:
                case ConnectionState.waiting:
                  return Center(
                    child: Text ("Carregando dados...",style: TextStyle(fontSize: 25.0))
                  );
                default:
                  dolar = snapshot.data["results"]["currencies"]["USD"]["buy"];
                  euro = snapshot.data["results"]["currencies"]["EUR"]["buy"];

                  return SingleChildScrollView(
                      child: Column(
                      children: <Widget>[
                        Icon(Icons.monetization_on,size: 120.0, color: Colors.amber,),
                        Divider(),
                       CampoDeTexto("Reais", "R\$",realController,_Real),
                       Divider(),
                        CampoDeTexto("Dolar", "U\$",dolarController,_Dolar),
                        Divider(),
                       CampoDeTexto("Euro", "EURO\$",euroController,_Euro)
                  ]
                ));
              }
            },
          )
    );
  }
}

Future<Map> buscarDadosDaApi() async {
  http.Response respostaDaApi = await http.get(urlApi);
  return json.decode(respostaDaApi.body);
}

Widget CampoDeTexto(String labelText, String prefixo, TextEditingController controller, Function r){
  return TextField(
        controller: controller,
        decoration: InputDecoration(
            labelText: "$labelText",
            border: OutlineInputBorder(),
          prefixText: "$prefixo",
        ),
        style: TextStyle(fontSize: 25.0),
        keyboardType: TextInputType.number,
        onChanged: r,
      );
}