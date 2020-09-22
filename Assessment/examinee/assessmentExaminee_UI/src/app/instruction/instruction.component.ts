import { Component, OnInit } from '@angular/core';
import { Instruction } from "../shared/instruction";
import { InstructionService } from "../services/instruction.service";
import { Params, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-instruction',
  templateUrl: './instruction.component.html',
  styleUrls: ['./instruction.component.scss']
})
export class InstructionComponent implements OnInit {

  instructions: Instruction[];

  constructor(private instructionService: InstructionService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    const qpId = this.route.snapshot.params['id'];
    this.instructionService.getInstructionOfQuestionPaper(qpId).subscribe((instructions) => this.instructions = instructions);
  }

}
