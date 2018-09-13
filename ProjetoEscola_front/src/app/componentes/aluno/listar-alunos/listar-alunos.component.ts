import { AlunoService } from './../../../servicos/aluno.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-listar-alunos',
  templateUrl: './listar-alunos.component.html',
  styleUrls: ['./listar-alunos.component.scss']
})
export class ListarAlunosComponent implements OnInit {

  alunos = [];

  cars: any[] = [
    {vin: "asdsd", year: "asd", brand: "asdasd", color:"asdas"},
    {vin: "asdsd", year: "asd", brand: "asdasd", color:"asdas"},
    {vin: "asd3sd", year: "asd", brand: "asdasd", color:"asdas"},
    {vin: "as3dsd", year: "asd", brand: "asdasd", color:"asdas"},
    {vin: "asd3sd", year: "asd", brand: "asdasd", color:"asdas"},
    {vin: "asdsd", year: "asd", brand: "asdasd", color:"asdas"},
    {vin: "5asd4sd", year: "asd", brand: "asdasd", color:"asdas"},
    {vin: "as6dsd", year: "asd", brand: "asdasd", color:"asdas"},
    {vin: "asd7sd", year: "asd", brand: "asdasd", color:"asdas"},
    {vin: "a8sdsd", year: "asd", brand: "asdasd", color:"asdas"},
    {vin: "asds9d", year: "asd", brand: "asdasd", color:"asdas"},
    {vin: "as0dsd", year: "asd", brand: "asdasd", color:"asdas"},
    {vin: "asd-sd", year: "asd", brand: "asdasd", color:"asdas"}
  ]

  cols: any[] = [
    { field: 'vin', header: 'Vin' },
    { field: 'year', header: 'Year' },
    { field: 'brand', header: 'Brand' },
    { field: 'color', header: 'Color' }
];

  constructor(private alunoService: AlunoService) { }

  ngOnInit() {
    this.pesquisar();
  }

  pesquisar(){
    
    this.alunoService.pesquisarAlunos()
      .then( alunos => this.alunos = alunos );
  }

}