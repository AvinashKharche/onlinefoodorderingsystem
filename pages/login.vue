<template>
  <div class="container">
    <div id="app" class="content login-panel">
      <div>
        <h1>Food Delivery App</h1>
      </div>
      <br>
      <br>
      <br>
      <br>
      <div class="content form-div">
        <form @submit.prevent="submitForm">
          <div>
            <label for="email">Email</label><br>
            <input id="email" type="email" v-model="email" required/>
          </div>
          <div>
            <label for="password">Password</label><br>
            <input id="password" type="password" v-model="password" required/>
          </div>
          <button :class="[email && password ? activeClass : '']" type="submit">Submit</button>
        </form>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      password: '',
      email: '',
      caps: '',
      response: '',
      activeClass: 'active'
    }
  },
  methods: {
    submitForm() {
      axios.post('//jsonplaceholder.typicode.com/posts', {
        name: this.name,
        email: this.email,
        caps: this.caps
      }).then(response => {
        this.response = JSON.stringify(response, null, 2)
      }).catch(error => {
        this.response = 'Error: ' + error.response.status
      })
    }
  }
}
</script>

<style lang="scss" scoped>

.login-panel {
  padding-top: 145px;
  text-align: center;

  h1 {
    font-size: 45px;
    color: #082c40;
  }
}

.form-div {
  text-align: center;
}

form {
  margin: 0 auto;
  display: table;
  width: 500px;
  text-align: left;

  label {
    letter-spacing: 10px;
    text-transform: uppercase;
    font-size: 15px;
    letter-spacing: 2px;
    font-weight: bold;
  }

  input {
    width: 100%;
    border: 1px solid #ccc;
  }

  input, textarea, button {
    border-radius: 4px;
    padding: 8px 15px;
    font-weight: 300;
  }

  div {
    margin: 20px 0;
  }
}

button {
  color: white;
  border: none;
  width: 100%;
  font-weight: 600;
  text-transform: uppercase;
  letter-spacing: 0.08em;
  background: #ccc;
  cursor: pointer;
  box-shadow: 0px 2px 3px rgba(0, 0, 0, 0.3);
  transition: 0.25s all ease;

  &:hover {
    transform: translateY(2px);
  }
}

.active {
  background: #082c40;
}

</style>
