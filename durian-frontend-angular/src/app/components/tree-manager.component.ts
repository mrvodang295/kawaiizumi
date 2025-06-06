import { Component, OnInit } from '@angular/core';
import { Tree, TreeService } from '../services/tree.service';

@Component({
  selector: 'app-tree-manager',
  templateUrl: './tree-manager.component.html'
})
export class TreeManagerComponent implements OnInit {
  trees: Tree[] = [];
  newTree: Tree = {
    treeId: '',
    variety: '',
    location: '',
    plantedDate: '',
    status: ''
  };

  constructor(private treeService: TreeService) {}

  ngOnInit(): void {
    this.fetchTrees();
  }

  fetchTrees() {
    this.treeService.getTrees().subscribe(data => this.trees = data);
  }

  addTree() {
    this.treeService.createTree(this.newTree).subscribe(() => {
      this.fetchTrees();
      this.newTree = { treeId: '', variety: '', location: '', plantedDate: '', status: '' };
    });
  }
}