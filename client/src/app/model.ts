export interface Address {
  id: number;
  addressLine1: string;
  addressLine2: string;
  city: string;
  state: string;
  postalCode: string;
  userId: number;
}

export interface Tickets {
  id: number;
  name: string;
  type: string;
  date: string;
  priority: string;
  status: boolean
  userId: number;
}

export interface Orders {
  id: number;
  date: string;
  status: string;
  total: number;
  userId: number;
}


export interface Posts {
  id: number,
  name: string,
  email: string,
  rating: string,
  review: string,
  positive: string,
  negative: string,
  productId: number
}

export interface Error {

  status: string
  statusText: string

}

export interface User {

  id: number;
  email: string;
  password: string;
  image: string;
  firstName: string;
  lastName: string;
  phone: string;
  posts: Array<Tickets>;
  orders: Array<Orders>;
  address: Array<Address>;

}

export interface Product {
  id: number
  name: string
  type: string
  brand: string
  specification: string
  image: string
  price: string
  count: number
  posts: Array<Posts>
}
