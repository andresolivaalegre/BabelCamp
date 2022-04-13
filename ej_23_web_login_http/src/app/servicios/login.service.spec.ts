import { TestBed } from '@angular/core/testing';

import { ValidacionService } from './login.service';

describe('ValidacionService', () => {
  let service: ValidacionService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ValidacionService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
