import axios from "axios";

const url = "http://localhost:8080/products";

export const listAllProducts = () => axios.get(url);
