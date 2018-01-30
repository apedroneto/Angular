import { Component, OnInit } from '@angular/core';

import { NgModel } from '@angular/forms';

@Component({
  selector: 'app-data-binding',
  templateUrl: './data-binding.component.html',
  styleUrls: ['./data-binding.component.css']
})
export class DataBindingComponent implements OnInit {

	url: string = 'http://loiane.com';

	cursoAngular: boolean = true;

	urlImagem: string = "https://vignette.wikia.nocookie.net/marvel_dc/images/3/32/Ra%27s_al_Ghul_0003.jpg";

	isMouseOver: boolean = false;


	nome: string = "abc";


	pessoa: any = {

		nome: "def",
		idade: 20,
		end: "21312312"

	}


	nomeDoCurso: string= "Angular 5"

	valorIncreDecre: number = 19;

	getValor() {

		return 1;

	}

	getCurtirCurso(){

		return true;

	}

	botaoClicado() {

		alert("botao clicado!");

	}

	onKeyUp(evento) {

		console.log(evento.key);

	}

	pressEnter() {


		console.log("enter press");

	}

	perdeuFoco() {

				console.log("perdeu foco");

	}


	onMouse() {

		this.isMouseOver = !this.isMouseOver;

	}

	offMouse() {

	}


	onMudouValor(evento) {

		console.log(evento);

	}

  constructor() { }

  ngOnInit() {
  }

}
