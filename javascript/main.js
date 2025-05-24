/* =====================================
   1. JavaScript Setup & Page Load
===================================== */
console.log("Welcome to the Community Portal");

window.addEventListener("load", () => {
  alert("Page fully loaded. Enjoy exploring the events!");
});

/* =====================================
   2. Event Data Setup & Basic Variables
===================================== */
const eventName = "Community Music Night";
const eventDate = "2025-06-15";
let availableSeats = 50;

const eventDetails = `${eventName} is on ${eventDate}. Seats left: ${availableSeats}`;
console.log(eventDetails);

/* Simulate seat booking */
function registerSeat() {
  if (availableSeats > 0) {
    availableSeats--;
    console.log(`Registered! Seats left: ${availableSeats}`);
  } else {
    console.log("No seats available.");
  }
}

/* =====================================
   3. Conditionals, Loops, Error Handling
===================================== */
const events = [
  { name: "Music Night", date: "2025-06-15", seats: 30, category: "music" },
  { name: "Art Workshop", date: "2024-05-10", seats: 0, category: "art" },
  { name: "Book Fair", date: "2025-07-20", seats: 15, category: "education" }
];

function displayAvailableEvents() {
  const today = new Date();
  events.forEach(evt => {
    const evtDate = new Date(evt.date);
    if (evtDate >= today && evt.seats > 0) {
      console.log(`Available: ${evt.name} - ${evt.date}`);
    }
  });
}

function tryRegister(event) {
  try {
    if (event.seats <= 0) throw new Error("No seats left.");
    event.seats--;
    console.log(`Successfully registered for ${event.name}. Seats remaining: ${event.seats}`);
  } catch (err) {
    console.error(`Registration failed: ${err.message}`);
  }
}

/* =====================================
   4. Functions, Closures, Filters
===================================== */
function addEvent(name, date, seats, category) {
  events.push({ name, date, seats, category });
}

function filterEventsByCategory(cat) {
  return events.filter(evt => evt.category === cat);
}

function createRegistrationCounter() {
  let count = 0;
  return function () {
    count++;
    console.log(`Total registrations in this category: ${count}`);
  };
}

const musicCounter = createRegistrationCounter();

/* =====================================
   5. Event Object & Prototype Method
===================================== */
function Event(name, date, seats, category) {
  this.name = name;
  this.date = date;
  this.seats = seats;
  this.category = category;
}

Event.prototype.checkAvailability = function () {
  return this.seats > 0;
};

const musicEvent = new Event("Jazz Evening", "2025-08-01", 25, "music");
console.log(Object.entries(musicEvent));

/* =====================================
   6. Arrays & Methods
===================================== */
const allEvents = [
  new Event("Yoga Class", "2025-09-01", 20, "health"),
  new Event("Cooking Workshop", "2025-10-01", 12, "food"),
  new Event("Live Music", "2025-11-15", 0, "music")
];

const musicOnly = allEvents.filter(e => e.category === "music");

const eventTitles = allEvents.map(e => `Workshop: ${e.name}`);
console.log(eventTitles);

/* =====================================
   7. DOM Manipulation
===================================== */
function renderEvents() {
  const container = document.querySelector("#eventList");
  container.innerHTML = ""; // clear previous

  allEvents.forEach(evt => {
    const card = document.createElement("div");
    card.className = "eventCard";
    card.innerHTML = `
      <h3>${evt.name}</h3>
      <p>Date: ${evt.date}</p>
      <p>Seats: ${evt.seats}</p>
      <button onclick="handleRegister('${evt.name}')">Register</button>
    `;
    container.appendChild(card);
  });
}

/* =====================================
   8. Event Handling
===================================== */
function handleRegister(eventName) {
  const evt = allEvents.find(e => e.name === eventName);
  if (evt && evt.seats > 0) {
    evt.seats--;
    alert(`Registered for ${evt.name}. Seats left: ${evt.seats}`);
    renderEvents(); // update UI
  } else {
    alert("Registration failed: No seats left.");
  }
}

document.querySelector("#categoryFilter")?.addEventListener("change", e => {
  const filtered = allEvents.filter(evt => evt.category === e.target.value);
  console.log("Filtered Events: ", filtered);
});

document.querySelector("#searchInput")?.addEventListener("keydown", e => {
  if (e.key === "Enter") {
    const term = e.target.value.toLowerCase();
    const found = allEvents.filter(evt => evt.name.toLowerCase().includes(term));
    console.log("Search Results: ", found);
  }
});

/* =====================================
   9. Async / Await & Loading Feedback
===================================== */
async function fetchEvents() {
  const spinner = document.querySelector("#loading");
  spinner.style.display = "block";

  try {
    const res = await fetch("https://jsonplaceholder.typicode.com/posts");
    const data = await res.json();
    console.log("Mock Events Fetched:", data.slice(0, 5));
  } catch (err) {
    console.error("Fetch failed:", err);
  } finally {
    spinner.style.display = "none";
  }
}

/* =====================================
   10. ES6+ Features
===================================== */
function describeEvent({ name, date, seats }) {
  console.log(`${name} is on ${date}. Available seats: ${seats}`);
}

const cloneEvents = [...allEvents];

/* =====================================
   11. Working with Forms
===================================== */
document.querySelector("#registerForm")?.addEventListener("submit", function (e) {
  e.preventDefault();

  const name = this.elements["name"].value.trim();
  const email = this.elements["email"].value.trim();
  const selectedEvent = this.elements["event"].value;

  if (!name || !email || !selectedEvent) {
    document.querySelector("#formError").textContent = "Please fill out all fields.";
    return;
  }

  console.log("Registering:", { name, email, selectedEvent });
  this.reset();
});

/* =====================================
   12. AJAX & Fetch Simulation
===================================== */
function sendRegistration(userData) {
  fetch("https://jsonplaceholder.typicode.com/posts", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(userData)
  })
    .then(res => res.json())
    .then(data => {
      console.log("Submitted:", data);
      document.querySelector("#formMessage").textContent = "Successfully submitted!";
    })
    .catch(err => {
      console.error("Submission error:", err);
      document.querySelector("#formMessage").textContent = "Submission failed.";
    });
}

/* =====================================
   13. Debugging & Logging
===================================== */
// Add breakpoints in browser, and use console logs below:
function debugSubmission(form) {
  const payload = {
    name: form.elements["name"].value,
    email: form.elements["email"].value,
    event: form.elements["event"].value
  };
  console.log("Payload:", payload);
}

/* =====================================
   14. jQuery and Frameworks
===================================== */
// Simulate jQuery if included
// $('#registerBtn').click(() => console.log("Registered using jQuery"));
// $('.eventCard').fadeIn();

console.log("React/Vue makes UI modular and state-driven.");
