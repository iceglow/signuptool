package se.su.it.signuptool

import se.su.it.signuptool.mock.UseCase

class MockService {

  private synchronized Long idCounter = 0L
  private List<UseCase> useCases = Collections.synchronizedList([])

  public List<UseCase> findAllByType(UseCase.Type type) {
    useCases.findAll { it.type == type }
  }

  public UseCase findByType(UseCase.Type type) {
    useCases.find { it.type == type }
  }

  public UseCase get(long id) {
    useCases.find { it.id == id }
  }

  public List<UseCase> getUseCases() {
    useCases
  }

  public void setUseCases(List<UseCase> useCases) {
    for(useCase in useCases) {
      useCase.id = idCounter++
      this.useCases << useCase
    }
  }
}
