package org.amrita.oop.fraction;

import java.lang.Math;

public class MatrixFraction {
 private Fraction[][] matrixFrac;

 // Constructor section

 MatrixFraction() { // default constructor - initializes to identity matrixFrac
  matrixFrac = new Fraction[3][3]; // First create array of 3x3 size
  matrixFrac[0][0] = new Fraction(1, 1); // Then populate the matrixFrac
  matrixFrac[0][1] = new Fraction(0, 1);
  matrixFrac[0][2] = new Fraction(0, 1);
  matrixFrac[1][0] = new Fraction(0, 1);
  matrixFrac[1][1] = new Fraction(1, 1);
  matrixFrac[1][2] = new Fraction(0, 1);
  matrixFrac[2][0] = new Fraction(0, 1);
  matrixFrac[2][1] = new Fraction(0, 1);
  matrixFrac[2][2] = new Fraction(1, 1);
 }

 MatrixFraction(Fraction f00, Fraction f01, Fraction f02,
  Fraction f10, Fraction f11, Fraction f12,
  Fraction f20, Fraction f21, Fraction f22) {
  matrixFrac = new Fraction[3][3];
  matrixFrac[0][0] = f00;
  matrixFrac[0][1] = f01;
  matrixFrac[0][2] = f02;
  matrixFrac[1][0] = f10;
  matrixFrac[1][1] = f11;
  matrixFrac[1][2] = f12;
  matrixFrac[2][0] = f20;
  matrixFrac[2][1] = f21;
  matrixFrac[2][2] = f22;
 }

 /** To set the values of all the elements of the matrixFrac */
 public void setMatrix(Fraction f00, Fraction f01, Fraction f02,
  Fraction f10, Fraction f11, Fraction f12,
  Fraction f20, Fraction f21, Fraction f22) {
  matrixFrac[0][0] = f00;
  matrixFrac[0][1] = f01;
  matrixFrac[0][2] = f02;
  matrixFrac[1][0] = f10;
  matrixFrac[1][1] = f11;
  matrixFrac[1][2] = f12;
  matrixFrac[2][0] = f20;
  matrixFrac[2][1] = f21;
  matrixFrac[2][2] = f22;
 }

 /** To set the value of a particular element of the matrixFrac */
 public void setElement(Fraction frac, int row, int column) {
  matrixFrac[row][column] = frac;
 }

 /** To get the value of a particular element of the matrixFrac */
 public Fraction getElement(int row, int column) {
  return matrixFrac[row][column];
 }

 /** To compute determinant */
 public Fraction determinant() {
  Fraction t1 = new Fraction() , t2 = new Fraction() , t3 = new Fraction();
  t1 = t1.add(getElement(1,1).multiply(getElement(2,2))).subtract(getElement(2,1).multiply(getElement(1,2))).multiply(getElement(0,0));
  t2 = t2.add(getElement(1,0).multiply(getElement(2,2))).subtract(getElement(2,0).multiply(getElement(1,2))).multiply(getElement(0,1));
  t3 = t3.add(getElement(1,0).multiply(getElement(2,1))).subtract(getElement(2,0).multiply(getElement(1,1))).multiply(getElement(0,2));
  Fraction t = new Fraction();
  t = t.add(t1).add(t3).subtract(t2);
  return t;
 }

 /** To compute transpose (non-mutable) */
 public MatrixFraction transpose() {
  MatrixFraction z = new MatrixFraction();
  for (int i = 0; i < 3; ++i) {
   for (int j = 0; j < 3; ++j) {
    z.setElement(this.getElement(j,i), i, j);
   }
  }
  return z;
 }

 /** Check if this is an identity matrixFrac */
 public boolean isIdentity() {
  for (int i = 0; i < 3; ++i) {
   for (int j = 0; j < 3; ++j) {
    if (i == j) {
     if (matrixFrac[i][j] != new Fraction(1, 1))
      return false;
    } else {
     if (matrixFrac[i][j] != new Fraction(0, 1))
      return false;
    }
   }
  }
  return true;
 }

 /** Check if this is an upper triangular matrixFrac */
 public boolean isUpperTriangular() {
  for (int i = 0; i < 3; ++i) {
   for (int j = 0; j < 3 - i; ++j) {
     if(j < i)
      if (getElement(i, j) != new Fraction(0, 1))
       return false;
   }
  }
  return true;
 }

 /** Check if this is a lower triangular matrixFrac */
 public boolean isLowerTriangular() {
  for (int i = 0; i < 3; ++i) {
   for (int j = i; j < 3; ++j) {
     if (j > i)
      if (getElement(i, j) != new Fraction(0, 1))
       return false;
   }
  }
  return true;
 }

 /** Check if two matrices are same */
 public boolean isSame(MatrixFraction mFrac) {
  for (int i = 0; i < 3; ++i) {
   for (int j = 0; j < 3; ++j) {
    if (getElement(i, j) != mFrac.getElement(i, j))
     return false;
   }
  }
  return true;
 }

 /** To compute the sum of two matrices */
 public MatrixFraction add(MatrixFraction mFrac) {
  MatrixFraction z = new MatrixFraction();
  for (int i = 0; i < 3; ++i) {
   for (int j = 0; j < 3; ++j) {
    z.setElement(mFrac.getElement(i, j).add(getElement(i, j)), i, j);
   }
  }
  return z;
 }

 /** To compute the difference between two matrices */
 public MatrixFraction subtract(MatrixFraction mFrac) {
  MatrixFraction z = new MatrixFraction();
  for (int i = 0; i < 3; ++i) {
   for (int j = 0; j < 3; ++j) {
    z.setElement(mFrac.getElement(i, j).subtract(getElement(i, j)), i, j);
   }
  }
  return z;
 }

 /** To compute the product of two matrices */
 public MatrixFraction multiply(MatrixFraction mFrac) {
  MatrixFraction z = new MatrixFraction();
  Fraction f00a = matrixFrac[0][0].multiply(mFrac.getElement(0, 0));
  Fraction f00b = matrixFrac[0][1].multiply(mFrac.getElement(1, 0));
  Fraction f00c = matrixFrac[0][2].multiply(mFrac.getElement(2, 0));
  Fraction f00 = f00a.add(f00b);
  f00 = f00.add(f00c);
  z.setElement(f00, 0, 0);

  Fraction f01a = matrixFrac[0][0].multiply(mFrac.getElement(0, 1));
  Fraction f01b = matrixFrac[0][1].multiply(mFrac.getElement(1, 1));
  Fraction f01c = matrixFrac[0][2].multiply(mFrac.getElement(2, 1));
  Fraction f01 = f01a.add(f01b);
  f01 = f01.add(f01c);
  z.setElement(f01, 0, 1);

  Fraction f02a = matrixFrac[0][0].multiply(mFrac.getElement(0, 2));
  Fraction f02b = matrixFrac[0][1].multiply(mFrac.getElement(1, 2));
  Fraction f02c = matrixFrac[0][2].multiply(mFrac.getElement(2, 2));
  Fraction f02 = f02a.add(f02b);
  f02 = f02.add(f02c);
  z.setElement(f02, 0, 2);

  Fraction f10a = matrixFrac[1][0].multiply(mFrac.getElement(0, 0));
  Fraction f10b = matrixFrac[1][1].multiply(mFrac.getElement(1, 0));
  Fraction f10c = matrixFrac[1][2].multiply(mFrac.getElement(2, 0));
  Fraction f10 = f10a.add(f10b);
  f10 = f10.add(f10c);
  z.setElement(f10, 1, 0);

  Fraction f11a = matrixFrac[1][0].multiply(mFrac.getElement(0, 1));
  Fraction f11b = matrixFrac[1][1].multiply(mFrac.getElement(1, 1));
  Fraction f11c = matrixFrac[1][2].multiply(mFrac.getElement(2, 1));
  Fraction f11 = f11a.add(f11b);
  f11 = f11.add(f11c);
  z.setElement(f11, 1, 1);

  Fraction f12a = matrixFrac[1][0].multiply(mFrac.getElement(0, 2));
  Fraction f12b = matrixFrac[1][1].multiply(mFrac.getElement(1, 2));
  Fraction f12c = matrixFrac[1][2].multiply(mFrac.getElement(2, 2));
  Fraction f12 = f12a.add(f12b);
  f12 = f12.add(f12c);
  z.setElement(f12, 1, 2);

  Fraction f20a = matrixFrac[2][0].multiply(mFrac.getElement(0, 0));
  Fraction f20b = matrixFrac[2][1].multiply(mFrac.getElement(1, 0));
  Fraction f20c = matrixFrac[2][2].multiply(mFrac.getElement(2, 0));
  Fraction f20 = f20a.add(f20b);
  f10 = f20.add(f20c);
  z.setElement(f20, 2, 0);

  Fraction f21a = matrixFrac[2][0].multiply(mFrac.getElement(0, 1));
  Fraction f21b = matrixFrac[2][1].multiply(mFrac.getElement(1, 1));
  Fraction f21c = matrixFrac[2][2].multiply(mFrac.getElement(2, 1));
  Fraction f21 = f21a.add(f21b);
  f21 = f21.add(f21c);
  z.setElement(f21, 2, 1);

  Fraction f22a = matrixFrac[2][0].multiply(mFrac.getElement(0, 2));
  Fraction f22b = matrixFrac[2][1].multiply(mFrac.getElement(1, 2));
  Fraction f22c = matrixFrac[2][2].multiply(mFrac.getElement(2, 2));
  Fraction f22 = f22a.add(f22b);
  f22 = f22.add(f22c);
  z.setElement(f22, 2, 2);
  return z;
 }

 /** To compute a matrixFrac with a scalar */
 public MatrixFraction scalarMultiply(int scalar) {
  MatrixFraction z = this;
  for (int i = 0; i < 3; ++i) {
   for (int j = 0; j < 3; ++j) {
    Fraction x = getElement(i, j);
    int n = x.getNumerator();
    n *= scalar;
    x.setNumerator(n);
    setElement(x, i, j);
   }
  }
  return z;
 }

 public MatrixFraction minor() {
  Fraction f00 =  getElement(1,1).multiply(getElement(2, 2)).subtract(getElement(2,1).multiply(getElement(1,2)));
  Fraction f01 =  getElement(1,0).multiply(getElement(2, 2)).subtract(getElement(2,0).multiply(getElement(1,2)));
  Fraction f02 =  getElement(1,0).multiply(getElement(2, 1)).subtract(getElement(2,0).multiply(getElement(1,1)));
  Fraction f10 =  getElement(0,1).multiply(getElement(2, 2)).subtract(getElement(2,1).multiply(getElement(0,2)));
  Fraction f11 =  getElement(0,0).multiply(getElement(2, 2)).subtract(getElement(2,0).multiply(getElement(0,2)));
  Fraction f12 =  getElement(0,0).multiply(getElement(2, 1)).subtract(getElement(2,0).multiply(getElement(0,1)));
  Fraction f20 =  getElement(0,1).multiply(getElement(1, 2)).subtract(getElement(1,1).multiply(getElement(0,2)));
  Fraction f21 =  getElement(0,0).multiply(getElement(1, 2)).subtract(getElement(1,0).multiply(getElement(0,2)));
  Fraction f22 =  getElement(0,0).multiply(getElement(1, 1)).subtract(getElement(1,0).multiply(getElement(0,1)));
  MatrixFraction z = new MatrixFraction(f00 , f01 , f02 , f10 , f11 , f12 , f20 , f21 , f22);
  return z;
 }

 public MatrixFraction coFactor(){
 	MatrixFraction z = this;
 	for (int i = 0; i < 3; ++i)
 	{
 		for (int j = 0; j < 3; ++j)
 		{
 			int mult = (int) Math.pow(-1 , i + j);
 			z.getElement(i,j).setNumerator(z.getElement(i,j).getNumerator() * mult);
 		}
 	}
 	return z;
 }

 /** To compute the inverse of a matrixFrac */
 public MatrixFraction inverse() {
  MatrixFraction z = this;
  Fraction det = this.determinant();
  float k = det.getValue();
  MatrixFraction transpose = z.minor().coFactor().transpose();
  for (int i = 0; i < 3; ++i)
 	{
 		for (int j = 0; j < 3; ++j)
 		{
 			transpose.getElement(i,j).multiply(det);
 		}
 	}
	return transpose;
 }
}
