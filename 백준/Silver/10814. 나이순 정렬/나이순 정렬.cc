#include <iostream>
#include <algorithm>

using namespace std;

class Person {
private: int age,id;
private: string name;

public: Person() {
    this->name = "";
    this->age = 0;
    this->id = 0;
}

public : Person(int age, string name,int id) {
        this->age = age;
        this->name = name;
        this->id = id;
    }
       
       int getAge() {
           return age;
       }
       string getName() {
           return name;
       }
       int getId() {
           return id;
       }
};

Person arr[100000];
bool compare(Person a, Person b) {
    if (a.getAge() == b.getAge()) {
        return a.getId() < b.getId();
    }
    else return a.getAge() < b.getAge();
}

int main() {
    ios::sync_with_stdio(0); cin.tie(0);
    int N;
    int age;
    int id = 1;
    cin >> N;
    string name;
    for (int i = 0; i < N; i++) {
        cin >> age >> name;
        arr[i] = Person(age, name,id);
        id++;
    }

  
    sort(arr, arr + N, compare);
    for (int i = 0; i < N; i++) {
        cout << arr[i].getAge() << " " << arr[i].getName() << "\n";
    }
    
    return 0;
}
