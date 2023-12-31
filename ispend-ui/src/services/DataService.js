import http from "../http-common";

class DataService {
  getAll() {
    return http.get("/plan");
  }

  get(id) {
    return http.get(`/plan/${id}`);
  }

  create(data) {
    return http.post("/plan", data);
  }

  update(id, data) {
    return http.put(`/plan/${id}`, data);
  }

  delete(id) {
    return http.delete(`/plan/${id}`);
  }

  deleteAll() {
    return http.delete(`/plans`);
  }

  findByTitle(title) {
    return http.get(`/plan?title=${title}`);
  }
}

export default new DataService();