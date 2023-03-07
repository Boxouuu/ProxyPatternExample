from abc import ABC, abstractmethod


class IPerson(ABC):

    @abstractmethod
    def printPersonInfo(self) -> None:
        pass


class Person(IPerson):

    def printPersonInfo(self) -> None:
        print("Voici les informations d'une personne")


class PersonProxy(IPerson):

    def __init__(self, person: Person) -> None:
        self._person = person

    
    def printPersonInfo(self) -> None:
        if self.check_access():
            self._person.printPersonInfo()
            self.log_access()


    def check_access(self) -> bool:
        print("Proxy: Verification des accès pour autoriser la méthode.")
        return True
    

    def log_access(self) -> None:
        print("Proxy: Log de la méthode.", end="")


def execute_code(person: IPerson) -> None:
    person.printPersonInfo()


if __name__ == "__main__":
    print("Client: Execution du code sans proxy")
    person = Person()
    execute_code(person)

    print("")

    print("Client: Execution du code avec proxy")
    personProxy = PersonProxy(person)
    execute_code(personProxy)