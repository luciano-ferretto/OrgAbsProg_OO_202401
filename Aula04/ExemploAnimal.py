class Animal:
    def get_cota_leite():
        return 0

class Elefante(Animal):
    def get_cota_leite(self):
        return 20.0
    
class Rato(Animal):
    def get_cota_leite(self):
        return 0.5

animal1 = Elefante()
print(f"Cota diária de leite do elefante: {animal1.get_cota_leite()}")
animal2 = Rato()
print(f"Cota diária de leite do rato: {animal2.get_cota_leite()}")


