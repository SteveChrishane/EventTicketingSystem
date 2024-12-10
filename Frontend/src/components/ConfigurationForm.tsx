import React, { useState } from "react";

interface ConfigurationProps {
  onSave: (config: {
    totalTickets: number;
    releaseRate: number;
    retrievalRate: number;
    maxCapacity: number;
  }) => void;
}

const ConfigurationForm: React.FC<ConfigurationProps> = ({ onSave }) => {
  const [totalTickets, setTotalTickets] = useState(100);
  const [releaseRate, setReleaseRate] = useState(1000);
  const [retrievalRate, setRetrievalRate] = useState(500);
  const [maxCapacity, setMaxCapacity] = useState(200);

  const handleSubmit = (e: React.FormEvent) => {
    e.preventDefault();
    onSave({ totalTickets, releaseRate, retrievalRate, maxCapacity });
  };

  return (
    <form onSubmit={handleSubmit}>
      <h2>Configuration</h2>
      <label>
        Total Tickets:
        <input
          type="number"
          value={totalTickets}
          onChange={(e) => setTotalTickets(Number(e.target.value))}
        />
      </label>
      <label>
        Ticket Release Rate (ms):
        <input
          type="number"
          value={releaseRate}
          onChange={(e) => setReleaseRate(Number(e.target.value))}
        />
      </label>
      <label>
        Customer Retrieval Rate (ms):
        <input
          type="number"
          value={retrievalRate}
          onChange={(e) => setRetrievalRate(Number(e.target.value))}
        />
      </label>
      <label>
        Max Ticket Capacity:
        <input
          type="number"
          value={maxCapacity}
          onChange={(e) => setMaxCapacity(Number(e.target.value))}
        />
      </label>
      <button type="submit">Save Configuration</button>
    </form>
  );
};

export default ConfigurationForm;
