import { TestBed } from '@angular/core/testing';

import { HeureSupService } from './heure-sup.service';

describe('HeureSupService', () => {
  let service: HeureSupService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(HeureSupService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
