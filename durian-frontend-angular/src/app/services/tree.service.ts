import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Tree {
  id?: string;
  treeId: string;
  variety: string;
  location: string;
  plantedDate: string;
  status: string;
}

@Injectable({ providedIn: 'root' })
export class TreeService {
  private apiUrl = 'https://durian-care.onrender.com/api/trees';

  constructor(private http: HttpClient) {}

  getTrees(): Observable<Tree[]> {
    return this.http.get<Tree[]>(this.apiUrl);
  }

  createTree(tree: Tree): Observable<Tree> {
    return this.http.post<Tree>(this.apiUrl, tree);
  }
}