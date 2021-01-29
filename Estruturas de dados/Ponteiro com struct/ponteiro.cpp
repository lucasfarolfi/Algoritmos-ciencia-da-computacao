#include <iostream>

using namespace std;

int main() {
  int a, *p;

  a = 10;
  p = &a;

  cout << a << endl;
  cout << &a << endl;
  cout << p << endl;
  cout << *p << endl;
}