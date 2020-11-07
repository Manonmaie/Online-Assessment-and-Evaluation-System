import { Component, OnInit } from '@angular/core';
import { Instruction } from "../shared/instruction";
import { InstructionService } from "../services/instruction.service";
import { LoginService } from "../services/login.service";
import { Params, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-instruction',
  templateUrl: './instruction.component.html',
  styleUrls: ['./instruction.component.scss']
})
export class InstructionComponent implements OnInit {

  instructions: Instruction[];
  examineeId: number;

  constructor(private instructionService: InstructionService, private loginService: LoginService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    const qpId = this.route.snapshot.params['id'];
    this.examineeId = this.loginService.getUserRole().user.userId;
    this.instructionService.getInstructionOfQuestionPaper(qpId).subscribe((instructions) => this.instructions = instructions);
  }

}
