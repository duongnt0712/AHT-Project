import { Component, EventEmitter, Input, OnChanges, OnDestroy, OnInit, Output, SimpleChanges} from '@angular/core';
import { DataService } from 'src/app/services/data.service';


@Component({
    selector: 'app-hello',
    template: `
        <h2>Hello from HelloComponent</h2>
    `,
})
export class HelloComponent implements OnInit, OnChanges, OnDestroy {

    @Input() text!: string;
    @Output() buttonClicked: EventEmitter<string> = new EventEmitter<string>();

    constructor(private _dataService: DataService) {

    }

    ngOnInit(): void {
        this._dataService.setTextFromHello(this.text);
    }

    ngOnChanges(changes: SimpleChanges): void {
        
    }

    ngOnDestroy(): void {
        
    }
}